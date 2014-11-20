package com.cs.gmu.project321;

/**
 * Created by Jacob on 11/20/14.
 */
public class RegulateTemp {

    double desiredTemp;
    double currentTemp;

    RegulateTemp(){
        //desiredTemp from CreateProgram
        //currentTemp from IndoorTempInterface
    }

    void setDesiredTemp(double dt){
        desiredTemp = dt;
    }

    double getDesiredTemp(){
        return desiredTemp;
    }

    double getCurrentTemp(){
        return currentTemp;
    }





    public class RegulateHeat {

        RegulateHeat(){

        }

        void activateHeatingUnit(){

        }

        void activateSecondUnit(){

        }

        void deactivateHeatingUnits(){

        }
    }

    public class RegulateAC {

        RegulateAC(){

        }

        void activateAC(){

        }

        void deactivateAC(){

        }


    }
    
}
