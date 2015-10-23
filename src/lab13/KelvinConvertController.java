/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2015
 *
 * Name: Dunni Adenuga
 * Date: Oct 22, 2015
 * Time: 10:00:45 PM
 *
 * Project: csci205
 * Package: lab13
 * File: KelvinConvertController
 * Description:
 *
 * ****************************************
 */
package lab13;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import lab13.KelvinConvertModel.TempUnits;

/**
 * Control Everything - Join Model,View and Utility
 *
 * @author ia005
 */
public class KelvinConvertController implements ActionListener, ChangeListener {
    private KelvinConvertModel theModel;
    private MainView theView;

    public KelvinConvertController(KelvinConvertModel theModel, MainView theView) {
        this.theModel = theModel;
        this.theView = theView;
        updateViewFromModel();

        theView.getSliderTemp().addChangeListener(this);
        theView.getRdbtnCelTemp().addActionListener(this);
        theView.getRdbtnFahTemp().addActionListener(this);
        theView.getTextMinTemp().addActionListener(this);
        theView.getTextMaxTemp().addActionListener(this);
    }

    /**
     * Update View(of components) From Model
     */
    private void updateViewFromModel() {
        if (theModel.getTempUnits() == TempUnits.FAH_TEMP) {
            theView.getRdbtnFahTemp().setSelected(true);
        } else {
            theView.getRdbtnCelTemp().setSelected(true);
        }
        theView.getSliderTemp().setModel(theModel.getTempRange());
        theView.getSliderTemp().setValue(theModel.getTempRange().getValue());
        theView.getTextMinTemp().setText(String.valueOf(
                theModel.getTempRange().getMinimum()));
        theView.getTextMaxTemp().setText(String.valueOf(
                theModel.getTempRange().getMaximum()));
        if (theModel.getTempUnits() == TempUnits.FAH_TEMP) {
            theView.getTextTempKelvin().setText(String.format("%.1f",
                                                              KelvinConvertUtility.convertFtoK(
                                                                      theModel.getTempRange().getValue())));
        } else {
            theView.getTextTempKelvin().setText(String.format("%.1f",
                                                              KelvinConvertUtility.convertCtoK(
                                                                      theModel.getTempRange().getValue())));
        }
        theView.getLblCurTemp().setText(String.valueOf(
                theModel.getTempRange().getValue()));
    }

    /**
     * Listen to change from components
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == theView.getTextMinTemp()) {
                theModel.getTempRange().setMinimum(Integer.valueOf(
                        theView.getTextMinTemp().getText()));
                updateViewFromModel();
            }
        } catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(theView, "Number Format Error!",
                                          theView.getTextMinTemp().getText() + " is not a number!",
                                          JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (e.getSource() == theView.getTextMaxTemp()) {
                theModel.getTempRange().setMaximum(Integer.valueOf(
                        theView.getTextMaxTemp().getText()));
                updateViewFromModel();
            }
        } catch (NumberFormatException a) {
            JOptionPane.showMessageDialog(theView, "Number Format Error!",
                                          theView.getTextMaxTemp().getText() + " is not a number!",
                                          JOptionPane.ERROR_MESSAGE);
        }
        if (e.getSource() == theView.getRdbtnCelTemp()) {
            theModel.setTempUnits(TempUnits.CEL_TEMP);
            updateViewFromModel();
        }
        if (e.getSource() == theView.getRdbtnFahTemp()) {
            theModel.setTempUnits(TempUnits.FAH_TEMP);
            updateViewFromModel();
        }
    }

    /**
     * Listen for change in slider
     *
     * @param e
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == theView.getSliderTemp()) {
            theModel.setTempRange(theView.getSliderTemp().getModel());
            updateViewFromModel();
        }
    }

}
