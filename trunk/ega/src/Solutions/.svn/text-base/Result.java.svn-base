/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Solutions;

import Presentacion.Auxiliares.OperationResult;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class Result {    
    public OperationResult result = new OperationResult();
    
    private String _timeLasted = "";
    private Integer _cicles = 0;
    private Integer _totalPopulation = 0;
    private Integer _totalMutations = 0;
    private Integer _maxAttitude = 0;
    private Integer _minAttitude = 0;
    
    private Integer[] _maxAttitudePoints;
    private String _maxPoints;
    private Integer[] _medAttitudePoints;
    private String _medPoints;
    private Integer[] _minAttitudePoints;
    private String _minPoints;
    
    private List _resultContent;
    private String _resultContentString;
    
    public static Result ToStore(String timeLasted, Integer cicles, Integer totalPopulation, Integer totalMutation, Integer maxAttitude, Integer minAttitude, List resultContent, Integer[] min, Integer[] med, Integer[] max){
        return new Result(timeLasted, cicles, totalPopulation, totalMutation, maxAttitude, minAttitude, resultContent, min, med, max);
    }
    
    public static Result Empty(){
        return new Result();
    }
    
    public void GenerateStringPoints(){
        this.setMaxPoints(this.getStringFromArray(this.getMaxAttitudePoints()));
        this.setMedPoints(this.getStringFromArray(this.getMedAttitudePoints()));
        this.setMinPoints(this.getStringFromArray(this.getMinAttitudePoints()));
    }
    
    public void GenerateIntegerArrayPoints(){
        this.setMaxAttitudePoints(this.getIntegerArrayFromString(this.getMaxPoints()));
        this.setMedAttitudePoints(this.getIntegerArrayFromString(this.getMedPoints()));
        this.setMinAttitudePoints(this.getIntegerArrayFromString(this.getMinPoints()));
    }
    
    private String getStringFromArray(Integer[] points){
        if (points == null || points.length == 0)
            return "";
        
        int amount = points.length;
        String _ret = "";
        
        for (int a = 0; a < amount; a++){
            _ret += points[a];
            if (a < amount - 1)
                _ret += ", ";
        }
        
        return _ret;
    }
    
     private Integer[] getIntegerArrayFromString(String points){
        if (points == null || points.isEmpty())
            return new Integer[1];
        
        String[] arrStrPoints = points.split(",");
        Integer amount = arrStrPoints.length;
        Integer[] arrIntPoints = new Integer[arrStrPoints.length];
        for (int a = 0 ; a < amount - 1; a++){
            arrIntPoints[a] = Integer.parseInt(arrStrPoints[a].trim());
        }
        
        return arrIntPoints;
    }
    
    
    public Result(){};
    
    public Result(String timeLasted, Integer cicles, Integer totalPopulation, Integer totalMutation, Integer maxAttitude, Integer minAttitude, List resultContent, Integer[] min, Integer[] med, Integer[] max){
        this._timeLasted = timeLasted != null ? timeLasted : "";
        this._cicles = cicles != null ? cicles : 0;
        this._totalPopulation = totalPopulation != null ? totalPopulation : 0;
        this._totalMutations = totalMutation != null ? totalMutation : 0;
        this._maxAttitude = maxAttitude != null ? maxAttitude : 0;
        this._minAttitude = minAttitude != null ? minAttitude : 0;
        this._resultContent = !resultContent.isEmpty() ? resultContent : null;
        this._maxAttitudePoints = max;
        this._medAttitudePoints = med;
        this._minAttitudePoints = min;
        
        this.GenerateStringPoints();
    }

    /**
     * @return the _timeLasted
     */
    public String getTimeLasted() {
        return _timeLasted;
    }

    /**
     * @param timeLasted the _timeLasted to set
     */
    public void setTimeLasted(String timeLasted) {
        this._timeLasted = timeLasted;
    }

    /**
     * @return the _cicles
     */
    public Integer getCicles() {
        return _cicles;
    }

    /**
     * @param cicles the _cicles to set
     */
    public void setCicles(Integer cicles) {
        this._cicles = cicles;
    }

    /**
     * @return the _totalPopulation
     */
    public Integer getTotalPopulation() {
        return _totalPopulation;
    }

    /**
     * @param totalPopulation the _totalPopulation to set
     */
    public void setTotalPopulation(Integer totalPopulation) {
        this._totalPopulation = totalPopulation;
    }

    /**
     * @return the _totalMutations
     */
    public Integer getTotalMutations() {
        return _totalMutations;
    }

    /**
     * @param totalMutations the _totalMutations to set
     */
    public void setTotalMutations(Integer totalMutations) {
        this._totalMutations = totalMutations;
    }

    /**
     * @return the _maxAttitude
     */
    public Integer getMaxAttitude() {
        return _maxAttitude;
    }

    /**
     * @param maxAttitude the _maxAttitude to set
     */
    public void setMaxAttitude(Integer maxAttitude) {
        this._maxAttitude = maxAttitude;
    }

    /**
     * @return the _minAttitude
     */
    public Integer getMinAttitude() {
        return _minAttitude;
    }

    /**
     * @param minAttitude the _minAttitude to set
     */
    public void setMinAttitude(Integer minAttitude) {
        this._minAttitude = minAttitude;
    }

    /**
     * @return the _resultContent
     */
    public List getResultContent() {
        return _resultContent;
    }

    /**
     * @param resultContent the _resultContent to set
     */
    public void setResultContent(List resultContent) {
        this._resultContent = resultContent;
    }

    /**
     * @return the _maxAttitudePoints
     */
    public Integer[] getMaxAttitudePoints() {
        return _maxAttitudePoints;
    }

    /**
     * @param maxAttitudePoints the _maxAttitudePoints to set
     */
    public void setMaxAttitudePoints(Integer[] maxAttitudePoints) {
        this._maxAttitudePoints = maxAttitudePoints;
    }

    /**
     * @return the _maxPoints
     */
    public String getMaxPoints() {
        return _maxPoints;
    }

    /**
     * @param maxPoints the _maxPoints to set
     */
    public void setMaxPoints(String maxPoints) {
        this._maxPoints = maxPoints;
    }

    /**
     * @return the _medAttitudePoints
     */
    public Integer[] getMedAttitudePoints() {
        return _medAttitudePoints;
    }

    /**
     * @param medAttitudePoints the _medAttitudePoints to set
     */
    public void setMedAttitudePoints(Integer[] medAttitudePoints) {
        this._medAttitudePoints = medAttitudePoints;
    }

    /**
     * @return the _medPoints
     */
    public String getMedPoints() {
        return _medPoints;
    }

    /**
     * @param medPoints the _medPoints to set
     */
    public void setMedPoints(String medPoints) {
        this._medPoints = medPoints;
    }

    /**
     * @return the _minAttitudePoints
     */
    public Integer[] getMinAttitudePoints() {
        return _minAttitudePoints;
    }

    /**
     * @param minAttitudePoints the _minAttitudePoints to set
     */
    public void setMinAttitudePoints(Integer[] minAttitudePoints) {
        this._minAttitudePoints = minAttitudePoints;
    }

    /**
     * @return the _minPoints
     */
    public String getMinPoints() {
        return _minPoints;
    }

    /**
     * @param minPoints the _minPoints to set
     */
    public void setMinPoints(String minPoints) {
        this._minPoints = minPoints;
    }

    /**
     * @return the _resultContentString
     */
    public String getResultContentString() {
        return _resultContentString;
    }

    /**
     * @param resultContentString the _resultContentString to set
     */
    public void setResultContentString(String resultContentString) {
        this._resultContentString = resultContentString;
    }
    
}
