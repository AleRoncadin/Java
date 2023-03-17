package FULL_COURSE.Modifiers.package2;
import FULL_COURSE.Modifiers.package1.*;      // importo il package che contiene la classe A

public class C {

    public String public_message = "This is public";                    // accessibile ovunque
    protected String protected_message = "This is protected";           // accessibile da classe, sottoclassi e package
    String default_message = "This is the default";                     // accessibile da classe, package
    private String private_message = "This is private";                 // accessibile solamente dalla classe
}
