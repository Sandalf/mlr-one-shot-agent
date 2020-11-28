/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.behaviours;

/**
 *
 * @author luissandoval
 */

import jade.core.Agent;

import jade.core.behaviours.OneShotBehaviour;

public class OneShotAgent extends Agent {

    private static final long serialVersionUID = 1L;

    protected void setup() {
        System.out.println("Agent " + getLocalName() + "started.");
        addBehaviour(new MyOneShotBehaviour());
    }

    private class MyOneShotBehaviour extends OneShotBehaviour {

        private static final long serialVersionUID = 1L;

        public void action() {
            Object[] args = getArguments();

            double xArg = 0;
            if (args != null && args.length > 0) {
                xArg = Double.parseDouble((String) args[0]);
            } else {
                System.out.println("You must pass an x value as an argument");
            }
    
            // Benetton data set: https://www.displayr.com/what-is-linear-regression/
            // X: Advertising, Y: Sales
            double[][] benettonData = {
                {23, 651},
                {26, 762},
                {30, 856},
                {34, 1063},
                {43, 1190},
                {48, 1298},
                {52, 1421},
                {57, 1440},
                {58, 1518}
            };
    
            // Inhabited private homes in Mexico: https://www.inegi.org.mx/temas/vivienda/#Informacion_general
            // X: Year, Y: Private homes in millions
            double[][] inegiData = {
                {1990, 16.18},
                {1995, 19.40},
                {2000, 21.94},
                {2005, 24.70},
                {2010, 28.60},
                {2015, 31.94}
            };
    
            Dataset dataset = new Dataset(inegiData);
            SimpleLinearRegression slr = new SimpleLinearRegression(dataset);
            slr.printEquation();
            slr.predict(xArg);
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
        
    }
    
}
