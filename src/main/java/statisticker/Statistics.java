package statisticker;

import java.util.List;

/**
 * @author msp5cob
 */
public class Statistics {


  /**
   * @author msp5cob
   */
  public class Stats {

    private final List<Float> numbers;
    private float average;
    private float min;
    private float max;

    /**
     * @param numbers numbers
     */
    public Stats(final List<Float> numbers) {
      this.numbers = numbers;
    }

    /**
     * caculate the Stats of the given numbers list
     */
    public void calculateStats() {
      float sum = 0f;
      int loopCount = 0;
      this.min = Float.NaN;
      this.max = Float.NaN;
      for (Float number : this.numbers) {
        if (loopCount == 0) {
          this.min = number;
          this.max = number;
        }
        else {
          this.min = Float.min(this.min, number);
          this.max = Float.max(this.max, number);
        }
        sum = Float.sum(sum, number);
        loopCount++;
      }
      this.average = sum / this.numbers.size();
    }

    /**
     * @return the average
     */
    public float getAverage() {
      return this.average;
    }

    /**
     * @param average the average to set
     */
    public void setAverage(final float average) {
      this.average = average;
    }

    /**
     * @return the min
     */
    public float getMin() {
      return this.min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(final float min) {
      this.min = min;
    }

    /**
     * @return the max
     */
    public float getMax() {
      return this.max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(final float max) {
      this.max = max;
    }

  }

  /**
   * @param numbers numbers List
   * @return Stats
   */
  public static Stats getStatistics(final List<Float> numbers) {
    // implement the computation of statistics here
    Statistics statisticsObj = new Statistics();
    Statistics.Stats stats = statisticsObj.new Stats(numbers);
    stats.calculateStats();
    return stats;
  }
}
