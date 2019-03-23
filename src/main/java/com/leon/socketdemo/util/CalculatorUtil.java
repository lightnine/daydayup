package com.leon.socketdemo.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * use JavaScript engine to calculator expression
 * @author leon
 * @date 2019/3/21
 */
public class CalculatorUtil {
    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
    public static Object cal(String expression){
        try {
            return jse.eval(expression);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }
}
