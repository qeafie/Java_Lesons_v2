package ru.shonin.reflection;

import ru.shonin.annotations.Validate;

@Validate({B.class,A.class})
public class B extends A{
     String text = "B";

}
