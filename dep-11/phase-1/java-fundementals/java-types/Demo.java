//package statement

//import statements

//type Definitions type = {class, enums, interface, annotations}

class A{}

//public class B{}   //cannot use public rule

interface C{}

enum D{}

@interface F{}

//public only use with type which is name exactly equal to name of file

public class Demo{}
//public interface Demo{}  cannot make same name different types

//best practice is to create different file to each type
