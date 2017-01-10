package sample.java.project;

//More comments

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

//adding random comments
//some more comments 
/**
 * The main class of the application. It contains the main() method,
 * the first method called.
 */
@NoArgsConstructor
@AllArgsConstructor
public class SampleJavaProject implements Runnable {

    /** The delay between printed messages. */
    private static final long PRINT_DELAY = 1000L;

    /** The name to be printed in the output message. */
    @Getter @Setter @NonNull
    @Parameter(names = "--name", description = "set the user's name",
               required = true)
    private String name = "world";

    /** Command line parameter for --loop. */
    @Parameter(names = "--loop", description = "print endlessly, hotswap demo")
    private boolean loop = false;

    /** Command line parameter for --help. */
    @Parameter(names = { "-h", "--help" }, description = "print help message")
    private boolean help = false;

    /**
     * Print the "Hello, world!" string.
     * @param args application input arguments
     */
    public static void main(final String[] args) {
        /* Parse command line arguments. */
        SampleJavaProject sjp = new SampleJavaProject();
        try {
            JCommander jc = new JCommander(sjp, args);
            if (sjp.help) {
                jc.usage();
                return;
            }
        } catch (ParameterException e) {
            System.err.println("error: " + e.getMessage());
            new JCommander(new SampleJavaProject()).usage();
            System.exit(-1);


        }

        sjp.run();
    }

    /**
     * Print the "Hello, world!" string.
     */
    public final void sayHello() {
        System.out.printf("Hello, %s!%n", name);
        printThis();
        printThisForTheTestBranch()
	printThis();
    }

    public static void changedMethodName(){
	int a = 1;
	int b = 2;
       int zero = 0;
        if(zero==1){System.println("zero")}
        else if(zero==1){System.out.println("zero");}
        else if(zero==2){System.out.println("zero");}
        else if(zero==3){System.out.println("zero");}
        else if(zero==4){System.out.println("zero");}
        else if(zero==5){System.out.println("zero");}
        else if(zero==6){System.out.println("zero");}
        else if(zero==7){System.out.println("zero");}
        else if(zero==8){System.out.println("zero");}
        else if(zero==9){System.out.println("zero");}
        else if(zero==10){System.out.println("zero");
	if(zero==a){if (a==b){if(b==zero)}}}
	}
        
    }

    public static void printThisForTheTestBranch(){

       int zero=0;
        if(zero==1){System.println("zero")}
        else if(zero==1){System.out.println("zero");}
        else if(zero==2){System.out.println("zero");}
        else if(zero==3){System.out.println("zero");}
        else if(zero==4){System.out.println("zero");}
        else if(zero==5){System.out.println("zero");}
        else if(zero==6){System.out.println("zero");}
        else if(zero==7){System.out.println("zero");}
        else if(zero==8){System.out.println("zero");}
        else if(zero==9){System.out.println("zero");}
        else if(zero==10){System.out.println("zero");}
        else if(zero==11){System.out.println("zero");}
        else if(zero==12){System.out.println("zero");}
        else if(zero==13){System.out.println("zero");}
        else if(zero==14){System.out.println("zero");}
        else if(zero==15){System.out.println("zero");}
        else {System.out.println("fail");}

    }

	public int tooManyArguments(int a, int b, int c, int d, int e, int f, int g)
	{
	return a;
	}
	public void insertChange(){

System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
System.out.prtinln("violation");
}

	public void newRFcandidate1(){
		
		System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
              System.out.println("Too many lines in this");
}

    @Override
    public final void run() {
        do {
            sayHello();
            try {
                Thread.sleep(PRINT_DELAY);
            } catch (InterruptedException e) {
                return;
            }
        } while (loop);
    }
}
