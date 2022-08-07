package models;

import java.util.regex.Pattern;
public class ValidateRE {
    /*
    isRe verifica si la expresión ingresada sea una Expresión Regular o no
     */
    public String isRE(String expression) {
        try {
            Pattern pattern = Pattern.compile(expression);
            return "La Expresion Regular es Valida";
        } catch (Exception e) {
            return "La Expresion Regular no es Valida";
        }
    }
}