package au.edu.swin.sdmd.tempconverter;

public class Conversion {

    public String toFahrenheit(String sCelsius) {
        try {
            double celsius = Double.parseDouble(sCelsius);
            double fahrenheit = celsius * (9.0 / 5.0) + 32;
            return String.format("%3.2f", fahrenheit);
        } catch (NumberFormatException nfe) {
            return "ERR";
        }
    }

    public String toCentimeter(String sInche) {
        try {
            double inches = Double.parseDouble(sInche);
            double cm = inches * 2.54;
            return String.format("%2.2f", cm);
        } catch (NumberFormatException nfe) {
            return "inche2cm ERR";
        }
    }

    public String toInches(String sFeet) {
        try {
            double feet = Double.parseDouble(sFeet);
            double inches = feet * 12;
            return String.format("%2.2f", inches);
        } catch (NumberFormatException nfe) {
            return "feet2inches ERR";
        }
    }

    public String toFeet(String sMile) {
        try {
            double mile = Double.parseDouble(sMile);
            double feet = mile * 5280;
            return String.format("%2.2f", feet);
        } catch (NumberFormatException nfe) {
            return "mile2feet ERR";
        }
    }

    public String inche2Metre(String sInche) {
        try {
            double inches = Double.parseDouble(sInche);
            double metre = inches * 0.0254;
            return String.format("%2.4f", metre);
        } catch (NumberFormatException nfe) {
            return "inche2Metre ERR";
        }
    }

    public String feet2Metre(String sFeet) {
        try {
            double feet = Double.parseDouble(sFeet);
            double metre = feet * 0.3048;
            return String.format("%2.4f", metre);
        } catch (NumberFormatException nfe) {
            return "feet2Metre ERR";
        }
    }

    public String mile2Metre(String sMile) {
        try {
            double mile = Double.parseDouble(sMile);
            double metre = mile * 1609.34;
            return String.format("%4.2f", metre);
        } catch (NumberFormatException nfe) {
            return "mile2Metre ERR";
        }
    }
}
