/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.tidsplan.modelo;

/**
 *
 * @author 1349397
 */
 public class LearningResultHasActivity {
    private Activity activity;
    private LearningResult learningResult;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public LearningResult getLearningResult() {
        return learningResult;
    }

    public void setLearningResult(LearningResult learningResult) {
        this.learningResult = learningResult;
    }
    
}
