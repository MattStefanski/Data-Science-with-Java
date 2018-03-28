package com.mattstefanski.datasciencewithjava;

import java.util.Random;
import java.lang.Math;
interface Function{
    double process(double x);
}



class SampleFunction implements Function{
    public double process(double x){
        return x+Math.pow(3, 5)+Math.pow(x,2.4)+Math.pow(2,5);
    }
}

class SimulatedAnnealingt{

    public double optimize(Function function,double x,double alpha, double temperature, double delta,int maxIter){
        double x_s=x;
        boolean finished=false;
        int currIter=1;
        double f_opt=function.process(x_s);
        double x_opt=x_s;
        double random_cs_seed;
        double random_activ_prob;
        while(!finished) {
            currIter=currIter+1;
            random_cs_seed = new Random().nextDouble();
            double x_c = x_s + (-delta + 2 * delta * random_cs_seed);
            double f_s = function.process(x_s);
            double f_c = functiongiy.process(x_c);
            double A = Math.min(1, Math.exp(-(f_c - f_s)/ temperature));
            random_activ_prob=new Random().nextDouble();
            if (random_activ_prob<A){
                x_s=x_c;

            }

            temperature=temperature*alpha;

            if (currIter<maxIter){
                if(f_s<f_opt){
                    f_opt=f_s;
                    x_opt=x_s;

                }
            }else {
                finished=true;
            }


        }
        return(x_opt);
    }
}