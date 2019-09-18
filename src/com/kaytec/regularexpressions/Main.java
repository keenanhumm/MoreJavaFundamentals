package com.kaytec.regularexpressions;


import static com.kaytec.utils.MyPrint.printBlankLine;

public class Main {
    public static void main(String[] args) {
        String iam = "I am a string. Yes, I am.";
        System.out.println(iam);
        String yourString = iam.replace("I", "You");
        System.out.println(yourString);

        printBlankLine();

        String alpha = "fjdljfalj;dajtklhew09090383838";
        System.out.println(alpha.replaceAll(".", "Y"));
        System.out.println(alpha.replaceAll("^fjdl", "YYYY"));

        printBlankLine();

        System.out.println(alpha.matches("^blah"));
        System.out.println(alpha.matches("^.*"));

        printBlankLine();

        System.out.println(alpha.matches("blah$"));
        System.out.println(alpha.matches(".*$"));

        printBlankLine();

        System.out.println(alpha.replaceAll("j[d;t]", "BOOM"));
        System.out.println(alpha.replaceAll("[^jd]", "Z"));
        System.out.println(alpha.replaceAll("[a-j]", "Z"));

        printBlankLine();

        System.out.println(alpha.replaceAll("\\d", "#"));
        System.out.println(alpha.replaceAll("\\D", "#"));

        printBlankLine();

        String withSpace = " fjls fldjs a flkdj\t fjlds";
        System.out.println(withSpace.replaceAll("\\s", ""));
        System.out.println(withSpace.replaceAll("\\S", ""));

        printBlankLine();


        System.out.println(withSpace.replaceAll("\\w", "T"));
        System.out.println(withSpace.replaceAll("\\b", "*"));

        printBlankLine();

        String repeater = "fkjdsjlyyyyyfldjsiiiiifjldsjeeeefjdlsdddddd";
        System.out.println(repeater.replaceAll("y{3}", ""));
        System.out.println(repeater.replaceAll("y{3,5}", ""));
        System.out.println(repeater.replaceAll("i+", ""));
        System.out.println(repeater.replaceAll("[yied]+", ""));

    }
}
