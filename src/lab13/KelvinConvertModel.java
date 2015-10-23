/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Oct 22, 2015
 * Time: 8:35:52 PM
 *
 * Project: csci205
 * Package: lab13
 * File: KelvinConvertModel
 * Description:
 *
 * ****************************************
 */
package lab13;

import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;

/**
 *
 * @author ia005
 */
public class KelvinConvertModel {

    public static enum TempUnits {
        FAH_TEMP, CEL_TEMP;
    }
    private double tempToConvert;
    private TempUnits tempUnits;
    private BoundedRangeModel tempRange;

    public KelvinConvertModel() {
        this.tempToConvert = 25.0;
        this.tempUnits = TempUnits.FAH_TEMP;
        this.tempRange = new DefaultBoundedRangeModel((int) tempToConvert, 0, 0,
                                                      100);
    }

    public double getTempToConvert() {
        return tempToConvert;
    }

    public void setTempToConvert(double tempToConvert) {
        this.tempToConvert = tempToConvert;
    }

    public TempUnits getTempUnits() {
        return tempUnits;
    }

    public void setTempUnits(TempUnits tempUnits) {
        this.tempUnits = tempUnits;
    }

    public BoundedRangeModel getTempRange() {
        return tempRange;
    }

    public void setTempRange(BoundedRangeModel tempRange) {
        this.tempRange = tempRange;
    }
}
