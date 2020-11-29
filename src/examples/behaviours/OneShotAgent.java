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
            double x1Arg = 0;
            double x2Arg = 0;

            if (args != null && args.length >= 2) {
                x1Arg = Double.parseDouble((String) args[0]);
                x2Arg = Double.parseDouble((String) args[1]);
            } else {
                System.out.println("You must pass x1 and x2 values as arguments");
                return;
            }
    
            double[][] exampleData = {
                {41.9, 29.1, 251.3},
                {43.4, 29.3, 251.3},
                {43.9, 29.5, 248.3},
                {44.5, 29.7, 267.5},
                {47.3, 29.9, 273},
                {47.5, 30.3, 276.5},
                {47.9, 30.5, 270.3},
                {50.2, 30.7, 274.9},
                {52.8, 30.8, 285},
                {53.2, 30.9, 290},
                {56.7, 31.5, 297},
                {57,   31.7, 302.5},
                {63.5, 31.9, 304.5},
                {65.3, 32,   309.3},
                {71.1, 32.1, 321.7},
                {77,   32.5, 330.7},
                {77.8, 32.9, 349}
            };
    
            Dataset dataset = new Dataset(exampleData);
            MultipleLinearRegression mlr = new MultipleLinearRegression(dataset);
            mlr.printEquation();
            mlr.predict(x1Arg, x2Arg);
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }
        
    }
    
}
