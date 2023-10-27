14.20.2. Execution of try-finally and try-catch-finally
A try statement with a finally block is executed by first executing the try block. Then there is a choice:

If execution of the try block completes normally, then the finally block is executed, and then there is a choice:

If the finally block completes normally, then the try statement completes normally.

If the finally block completes abruptly for reason S, then the try statement completes abruptly for reason S.

If execution of the try block completes abruptly because of a throw of a value V, then there is a choice:

If the run-time type of V is assignment compatible with a catchable exception class of any catch clause of the try statement, then the first (leftmost) such catch clause is selected. The value V is assigned to the parameter of the selected catch clause, and the Block of that catch clause is executed. Then there is a choice:

If the catch block completes normally, then the finally block is executed. Then there is a choice:

If the finally block completes normally, then the try statement completes normally.

If the finally block completes abruptly for any reason, then the try statement completes abruptly for the same reason.

If the catch block completes abruptly for reason R, then the finally block is executed. Then there is a choice:

If the finally block completes normally, then the try statement completes abruptly for reason R.

If the finally block completes abruptly for reason S, then the try statement completes abruptly for reason S (and reason R is discarded).

If the run-time type of V is not assignment compatible with a catchable exception class of any catch clause of the try statement, then the finally block is executed. Then there is a choice:

If the finally block completes normally, then the try statement completes abruptly because of a throw of the value V.

If the finally block completes abruptly for reason S, then the try statement completes abruptly for reason S (and the throw of value V is discarded and forgotten).

If execution of the try block completes abruptly for any other reason R, then the finally block is executed, and then there is a choice:

If the finally block completes normally, then the try statement completes abruptly for reason R.

If the finally block completes abruptly for reason S, then the try statement completes abruptly for reason S (and reason R is discarded).

Example 14.20.2-1. Handling An Uncaught Exception With finally

class BlewIt extends Exception {
    BlewIt() { }
    BlewIt(String s) { super(s); }
}
class Test {
    static void blowUp() throws BlewIt {
        throw new NullPointerException();
    }
    public static void main(String[] args) {
        try {
            blowUp();
        } catch (BlewIt b) {
            System.out.println("Caught BlewIt");
        } finally {
            System.out.println("Uncaught Exception");
        }
    }
}
This program produces the output:

Uncaught Exception
Exception in thread "main" java.lang.NullPointerException
        at Test.blowUp(Test.java:7)
        at Test.main(Test.java:11)
The NullPointerException (which is a kind of RuntimeException) that is thrown by method blowUp is not caught by the try statement in main, because a NullPointerException is not assignable to a variable of type BlewIt. This causes the finally clause to execute, after which the thread executing main, which is the only thread of the test program, terminates because of an uncaught exception, which typically results in printing the exception name and a simple backtrace. However, a backtrace is not required by this specification.

The problem with mandating a backtrace is that an exception can be created at one point in the program and thrown at a later one. It is prohibitively expensive to store a stack trace in an exception unless it is actually thrown (in which case the trace may be generated while unwinding the stack). Hence we do not mandate a back trace in every exception.


14.20.3. try-with-resources
A try-with-resources statement is parameterized with local variables (known as resources) that are initialized before execution of the try block and closed automatically, in the reverse order from which they were initialized, after execution of the try block. catch clauses and a finally clause are often unnecessary when resources are closed automatically.

TryWithResourcesStatement:
try ResourceSpecification Block [Catches] [Finally]
ResourceSpecification:
( ResourceList [;] )
ResourceList:
Resource {; Resource}
Resource:
{VariableModifier} LocalVariableType Identifier = Expression
VariableAccess
VariableAccess:
ExpressionName
FieldAccess
The following productions from §8.4.1 and §14.4 are shown here for convenience:

VariableModifier:
Annotation
final
LocalVariableType:
UnannType
var
A resource specification uses variables to denote resources for the try statement, either by declaring local variables with initializer expressions or by referring to suitable existing variables. An existing variable is referred to by either an expression name (§6.5.6) or a field access expression (§15.11).

It is a compile-time error for a resource specification to declare two variables with the same name.

It is a compile-time error if final appears more than once as a modifier for each variable declared in a resource specification.

A variable declared in a resource specification is implicitly declared final if it is not explicitly declared final (§4.12.4).

A resource denoted by an expression name or field access expression must be a final or effectively final variable that is definitely assigned before the try-with-resources statement (§16 (Definite Assignment)), or a compile-time error occurs.

It is a compile-time error if the LocalVariableType of a variable declared in a resource specification is var and the initializer expression contains a reference to the variable.

The type of a variable declared in a resource specification is determined as follows:

If LocalVariableType is an UnannType, then UnannType denotes the type of the local variable.

If LocalVariableType is var, then let T be the type of the initializer expression when treated as if it did not appear in an assignment context, and were thus a standalone expression (§15.2). The type of the local variable is the upward projection of T with respect to all synthetic type variables mentioned by T (§4.10.5).

It is a compile-time error if T is the null type.

The type of a variable declared or referred to as a resource in a resource specification must be a subtype of AutoCloseable, or a compile-time error occurs.

The scope and shadowing of a variable declared in a resource specification is specified in §6.3 and §6.4.

Resources are initialized in left-to-right order. If a resource fails to initialize (that is, its initializer expression throws an exception), then all resources initialized so far by the try-with-resources statement are closed. If all resources initialize successfully, the try block executes as normal and then all non-null resources of the try-with-resources statement are closed.

Resources are closed in the reverse order from that in which they were initialized. A resource is closed only if it initialized to a non-null value. An exception from the closing of one resource does not prevent the closing of other resources. Such an exception is suppressed if an exception was thrown previously by an initializer, the try block, or the closing of a resource.

A try-with-resources statement whose resource specification indicates multiple resources is treated as if it were multiple try-with-resources statements, each of which has a resource specification that indicates a single resource. When a try-with-resources statement with n resources (n > 1) is translated, the result is a try-with-resources statement with n-1 resources. After n such translations, there are n nested try-catch-finally statements, and the overall translation is complete.

14.20.3.1. Basic try-with-resources
A try-with-resources statement with no catch clauses or finally clause is called a basic try-with-resources statement.

If a basic try-with-resource statement is of the form:

try (VariableAccess ...)
    Block
then the resource is first converted to a local variable declaration by the following translation:

try (T #r = VariableAccess ...) {
    Block
}
T is the type of the variable denoted by VariableAccess and #r is an automatically generated identifier that is distinct from any other identifiers (automatically generated or otherwise) that are in scope at the point where the try-with-resources statement occurs. The try-with-resources statement is then translated according to the rest of this section.

The meaning of a basic try-with-resources statement of the form:

try ({VariableModifier} R Identifier = Expression ...)
    Block
is given by the following translation to a local variable declaration and a try-catch-finally statement:

{
    final {VariableModifierNoFinal} R Identifier = Expression;
    Throwable #primaryExc = null;

    try ResourceSpecification_tail
        Block
    catch (Throwable #t) {
        #primaryExc = #t;
        throw #t;
    } finally {
        if (Identifier != null) {
            if (#primaryExc != null) {
                try {
                    Identifier.close();
                } catch (Throwable #suppressedExc) {
                    #primaryExc.addSuppressed(#suppressedExc);
                }
            } else {
                Identifier.close();
            }
        }
    }
}
{VariableModifierNoFinal} is defined as {VariableModifier} without final, if present.

#t, #primaryExc, and #suppressedExc are automatically generated identifiers that are distinct from any other identifiers (automatically generated or otherwise) that are in scope at the point where the try-with-resources statement occurs.

If the resource specification indicates one resource, then ResourceSpecification_tail is empty (and the try-catch-finally statement is not itself a try-with-resources statement).

If the resource specification indicates n > 1 resources, then ResourceSpecification_tail consists of the 2nd, 3rd, ..., n'th resources indicated in the resource specification, in the same order (and the try-catch-finally statement is itself a try-with-resources statement).

Reachability and definite assignment rules for the basic try-with-resources statement are implicitly specified by the translation above.

In a basic try-with-resources statement that manages a single resource:

If the initialization of the resource completes abruptly because of a throw of a value V, then the try-with-resources statement completes abruptly because of a throw of the value V.

If the initialization of the resource completes normally, and the try block completes abruptly because of a throw of a value V, then:

If the automatic closing of the resource completes normally, then the try-with-resources statement completes abruptly because of a throw of the value V.

If the automatic closing of the resource completes abruptly because of a throw of a value V2, then the try-with-resources statement completes abruptly because of a throw of value V with V2 added to the suppressed exception list of V.

If the initialization of the resource completes normally, and the try block completes normally, and the automatic closing of the resource completes abruptly because of a throw of a value V, then the try-with-resources statement completes abruptly because of a throw of the value V.

In a basic try-with-resources statement that manages multiple resources:

If the initialization of a resource completes abruptly because of a throw of a value V, then:

If the automatic closings of all successfully initialized resources (possibly zero) complete normally, then the try-with-resources statement completes abruptly because of a throw of the value V.

If the automatic closings of all successfully initialized resources (possibly zero) complete abruptly because of throws of values V1...Vn, then the try-with-resources statement completes abruptly because of a throw of the value V with any remaining values V1...Vn added to the suppressed exception list of V.

If the initialization of all resources completes normally, and the try block completes abruptly because of a throw of a value V, then:

If the automatic closings of all initialized resources complete normally, then the try-with-resources statement completes abruptly because of a throw of the value V.

If the automatic closings of one or more initialized resources complete abruptly because of throws of values V1...Vn, then the try-with-resources statement completes abruptly because of a throw of the value V with any remaining values V1...Vn added to the suppressed exception list of V.

If the initialization of every resource completes normally, and the try block completes normally, then:

If one automatic closing of an initialized resource completes abruptly because of a throw of value V, and all other automatic closings of initialized resources complete normally, then the try-with-resources statement completes abruptly because of a throw of the value V.

If more than one automatic closing of an initialized resource completes abruptly because of throws of values V1...Vn, then the try-with-resources statement completes abruptly because of a throw of the value V1 with any remaining values V2...Vn added to the suppressed exception list of V1 (where V1 is the exception from the rightmost resource failing to close and Vn is the exception from the leftmost resource failing to close).

14.20.3.2. Extended try-with-resources
A try-with-resources statement with at least one catch clause and/or a finally clause is called an extended try-with-resources statement.

The meaning of an extended try-with-resources statement:

try ResourceSpecification
    Block
[Catches]
[Finally]
is given by the following translation to a basic try-with-resources statement nested inside a try-catch or try-finally or try-catch-finally statement:

try {
    try ResourceSpecification
        Block
}
[Catches]
[Finally]
The effect of the translation is to put the resource specification "inside" the try statement. This allows a catch clause of an extended try-with-resources statement to catch an exception due to the automatic initialization or closing of any resource.

Furthermore, all resources will have been closed (or attempted to be closed) by the time the finally block is executed, in keeping with the intent of the finally keyword.

14.21. Unreachable Statements
It is a compile-time error if a statement cannot be executed because it is unreachable.

This section is devoted to a precise explanation of the word "reachable." The idea is that there must be some possible execution path from the beginning of the constructor, method, instance initializer, or static initializer that contains the statement to the statement itself. The analysis takes into account the structure of statements. Except for the special treatment of while, do, and for statements whose condition expression has the constant value true, the values of expressions are not taken into account in the flow analysis.

For example, a Java compiler will accept the code:

{
    int n = 5;
    while (n > 7) k = 2;
}
even though the value of n is known at compile time and in principle it can be known at compile time that the assignment to k can never be executed.

The rules in this section define two technical terms:

whether a statement is reachable

whether a statement can complete normally

The definitions here allow a statement to complete normally only if it is reachable.

To shorten the description of the rules, the customary abbreviation "iff" is used to mean "if and only if."

A reachable break statement exits a statement if, within the break target, either there are no try statements whose try blocks contain the break statement, or there are try statements whose try blocks contain the break statement and all finally clauses of those try statements can complete normally.

This definition is based on the logic around "attempts to transfer control" in §14.15.

A continue statement continues a do statement if, within the do statement, either there are no try statements whose try blocks contain the continue statement, or there are try statements whose try blocks contain the continue statement and all finally clauses of those try statements can complete normally.

The rules are as follows:

The block that is the body of a constructor, method, instance initializer, or static initializer is reachable.

An empty block that is not a switch block can complete normally iff it is reachable.

A non-empty block that is not a switch block can complete normally iff the last statement in it can complete normally.

The first statement in a non-empty block that is not a switch block is reachable iff the block is reachable.

Every other statement S in a non-empty block that is not a switch block is reachable iff the statement preceding S can complete normally.

A local class declaration statement can complete normally iff it is reachable.

A local variable declaration statement can complete normally iff it is reachable.

An empty statement can complete normally iff it is reachable.

A labeled statement can complete normally if at least one of the following is true:

The contained statement can complete normally.

There is a reachable break statement that exits the labeled statement.

The contained statement is reachable iff the labeled statement is reachable.

An expression statement can complete normally iff it is reachable.

An if-then statement can complete normally iff it is reachable.

The then-statement is reachable iff the if-then statement is reachable.

An if-then-else statement can complete normally iff the then-statement can complete normally or the else-statement can complete normally.

The then-statement is reachable iff the if-then-else statement is reachable.

The else-statement is reachable iff the if-then-else statement is reachable.

This handling of an if statement, whether or not it has an else part, is rather unusual. The rationale is given at the end of this section.

An assert statement can complete normally iff it is reachable.

A switch statement can complete normally iff at least one of the following is true:

The switch block is empty or contains only switch labels.

The last statement in the switch block can complete normally.

There is at least one switch label after the last switch block statement group.

The switch block does not contain a default label.

There is a reachable break statement that exits the switch statement.

A switch block is reachable iff its switch statement is reachable.

A statement in a switch block is reachable iff its switch statement is reachable and at least one of the following is true:

It bears a case or default label.

There is a statement preceding it in the switch block and that preceding statement can complete normally.

A while statement can complete normally iff at least one of the following is true:

The while statement is reachable and the condition expression is not a constant expression (§15.28) with value true.

There is a reachable break statement that exits the while statement.

The contained statement is reachable iff the while statement is reachable and the condition expression is not a constant expression whose value is false.

A do statement can complete normally iff at least one of the following is true:

The contained statement can complete normally and the condition expression is not a constant expression (§15.28) with value true.

The do statement contains a reachable continue statement with no label, and the do statement is the innermost while, do, or for statement that contains that continue statement, and the continue statement continues that do statement, and the condition expression is not a constant expression with value true.

The do statement contains a reachable continue statement with a label L, and the do statement has label L, and the continue statement continues that do statement, and the condition expression is not a constant expression with value true.

There is a reachable break statement that exits the do statement.

The contained statement is reachable iff the do statement is reachable.

A basic for statement can complete normally iff at least one of the following is true:

The for statement is reachable, there is a condition expression, and the condition expression is not a constant expression (§15.28) with value true.

There is a reachable break statement that exits the for statement.

The contained statement is reachable iff the for statement is reachable and the condition expression is not a constant expression whose value is false.

An enhanced for statement can complete normally iff it is reachable.

A break, continue, return, or throw statement cannot complete normally.

A synchronized statement can complete normally iff the contained statement can complete normally.

The contained statement is reachable iff the synchronized statement is reachable.

A try statement can complete normally iff both of the following are true:

The try block can complete normally or any catch block can complete normally.

If the try statement has a finally block, then the finally block can complete normally.

The try block is reachable iff the try statement is reachable.

A catch block C is reachable iff both of the following are true:

Either the type of C's parameter is an unchecked exception type or Exception or a superclass of Exception, or some expression or throw statement in the try block is reachable and can throw a checked exception whose type is assignable to the type of C's parameter. (An expression is reachable iff the innermost statement containing it is reachable.)

See §15.6 for normal and abrupt completion of expressions.

There is no earlier catch block A in the try statement such that the type of C's parameter is the same as or a subclass of the type of A's parameter.

The Block of a catch block is reachable iff the catch block is reachable.

If a finally block is present, it is reachable iff the try statement is reachable.

One might expect the if statement to be handled in the following manner:

An if-then statement can complete normally iff at least one of the following is true:

The if-then statement is reachable and the condition expression is not a constant expression whose value is true.

The then-statement can complete normally.

The then-statement is reachable iff the if-then statement is reachable and the condition expression is not a constant expression whose value is false.

An if-then-else statement can complete normally iff the then-statement can complete normally or the else-statement can complete normally.

The then-statement is reachable iff the if-then-else statement is reachable and the condition expression is not a constant expression whose value is false.

The else-statement is reachable iff the if-then-else statement is reachable and the condition expression is not a constant expression whose value is true.

This approach would be consistent with the treatment of other control structures. However, in order to allow the if statement to be used conveniently for "conditional compilation" purposes, the actual rules differ.

As an example, the following statement results in a compile-time error:

while (false) { x=3; }
because the statement x=3; is not reachable; but the superficially similar case:

if (false) { x=3; }
does not result in a compile-time error. An optimizing compiler may realize that the statement x=3; will never be executed and may choose to omit the code for that statement from the generated class file, but the statement x=3; is not regarded as "unreachable" in the technical sense specified here.

The rationale for this differing treatment is to allow programmers to define "flag" variables such as:

static final boolean DEBUG = false;
and then write code such as:

if (DEBUG) { x=3; }
The idea is that it should be possible to change the value of DEBUG from false to true or from true to false and then compile the code correctly with no other changes to the program text.

Conditional compilation comes with a caveat. If a set of classes that use a "flag" variable - or more precisely, any static constant variable (§4.12.4) - are compiled and conditional code is omitted, it does not suffice later to distribute just a new version of the class or interface that contains the definition of the flag. The classes that use the flag will not see its new value, so their behavior may be surprising. In essence, a change to the value of a flag is binary compatible with pre-existing binaries (no LinkageError occurs) but not behaviorally compatible.

Another reason for "inlining" values of static constant variables is because of switch statements. They are the only kind of statement that relies on constant expressions, namely that each case label of a switch statement must be a constant expression whose value is different than every other case label. case labels are often references to static constant variables so it may not be immediately obvious that all the labels have different values. If it is proven that there are no duplicate labels at compile time, then inlining the values into the class file ensures there are no duplicate labels at run time either - a very desirable property.

Example 14.21-1. Conditional Compilation

If the example:

class Flags { static final boolean DEBUG = true; }
class Test {
    public static void main(String[] args) {
        if (Flags.DEBUG)
            System.out.println("DEBUG is true");
    }
}
is compiled and executed, it produces the output:

DEBUG is true
Suppose that a new version of class Flags is produced:

class Flags { static final boolean DEBUG = false; }
If Flags is recompiled but not Test, then running the new binary with the existing binary of Test produces the output:

