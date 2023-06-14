/**
* Creating several methods to manipulate monaural wave files. In these methods,
* we create, traverse, manipulate, and return arrays. 
*
* @author Abby Ramos Cortez
*
* @version 19.0.1 2023-3-25
*
*/
import java.util.Arrays;

public class SoundManipulationAdv
{
    /** 
    * Changes the volume of a sound by a factor. When the factor is greater than
    * one, the volume is increased, and when the factor is less than one, the volume
    * is decreased.
    *
    * @param soundData an array that represents the sound data
    * @param factor the factor to use for changing the volume
    * @return an updated array containing the sound data with its 
    * volume changed
    */
    public static double[] changeVolume(double[] soundData, double factor)
    {
        double[] newSoundData = new double[soundData.length];
        for (int i = 0; i < soundData.length; i++)
        {
            newSoundData[i] = soundData[i] * factor;
        }
        return newSoundData;
    }

    /** 
    * Increases the volume by 100%
    *
    * @param soundData an array that represents the sound data
    * @return an updated array containing the sound data with its 
    * volume increased by 100%
    */
    public static double[] increaseVolume(double[] soundData)
    {
        return changeVolume(soundData, 2); 
    }

    /** 
    * Decrease the volume by 50%
    *
    * @param soundData an array that represents the sound data
    * @return an updated array containing the sound data with its 
    * volume decreased by 50%
    */
    public static double[] decreaseVolume(double[] soundData)
    {
        return changeVolume(soundData, 1.0 / 2.0); 
    }

    /** 
    * Produces a fragment from a sound based on a starting index (inclusive) and
    * an ending index (exclusive). Both indices must be within the bounds of sound
    * data length (inclusive). 
    *
    * @param soundData an array of doubles containing sound data
    * @param start the starting index
    * @param end the ending index
    * @return an array of doubles containing sound data from the starting index
    * up to the ending index
    */
    public static double[] splitSound(double[] soundData, int start, int end)
    {
        if (start >= 0 && end >= 0 && end <= soundData.length && (end - start) > 0)
        {
            double[] newSoundData = new double[end - start];
            int index = 0;
            for (int i = start; i < end; i++)
            {
                newSoundData[index++] = soundData[i];
            }
            return newSoundData;
        }
        return new double[0];
    }

    /** 
    * Decreases the volume for the first half of the sound data and increases the
    * volume for the second half of the sound data.
    *
    * @param soundData an array of doubles containing sound data
    * @return an array of doubles with the appropriate changes made to the first
    * half(decrease volume)and the second half(increase volume) of the sound data
    */
    public static double[] decreaseIncreaseVolume(double[] soundData)
    {
        double newSoundData[] = new double[soundData.length];
        double[] firstHalf = decreaseVolume(splitSound(soundData, 0, 
            soundData.length / 2)); // the program splits the sound data first
            // then decreases the volume
        double[] secondHalf = increaseVolume(splitSound(soundData, 
            soundData.length / 2, soundData.length));
        
        int index = 0;
        for (int i = 0; i < firstHalf.length; i++)
        {
            newSoundData[index] = firstHalf[i];
            index++;
        }
        for (int j = 0; j < secondHalf.length; j++)
        {
            newSoundData[index] = secondHalf[j];
            index++;
        }
        return newSoundData;
    }

    /** 
    * Halves the speed of the original sound data by doubling the sound frequency to
    * (slows down the volume)
    *
    * @param soundData an array of doubles containing sound data
    * @return an array of doubles with each value in the soundData array repeating
    * twice
    */
    public static double[] halveSpeed(double[] soundData)
    {
        double[] newSoundData = new double[soundData.length * 2];
        int index = 0;
        for (int i = 0; i < newSoundData.length - 1; i++)
        {
            newSoundData[i] = soundData[index]; // pair 1/2 of a value in the 
            // soundData array
            newSoundData[i += 1] = soundData[index]; // pair 2/2 of a value in
            // the soundData array
            index++;
        }
        return newSoundData;
    }

    /** 
    * Doubles the speed of the original sound by halving the sound frequency
    * (speeds up a sound)
    *
    * @param soundData an array of doubles containing sound data
    * @return an array of doubles containing values that are in odd indices in
    * the soundData array
    */
    public static double[] doubleSpeed(double[] soundData)
    {
        double[] newSoundData = new double[soundData.length / 2];
        int index = 0;
        for (int i = 1; i < soundData.length; i += 2) // i = odd indices in 
        // soundData
        {
            newSoundData[index] = soundData[i];
            index++;
        }
        return newSoundData;
    }

    /** 
    * Slows the speed for the first half of the sound data and increases the speed
    * for the second half of the sound data.
    *
    * @param soundData an array of doubles containing sound data
    * @return an array of doubles with the appropriate changes made to the first
    * half(slow the speed)and the second half(increase the speed) of the sound 
    * data
    */
    public static double[] slowFastSpeed(double[] soundData)
    {
        double[] firstHalf = halveSpeed(splitSound(soundData, 0, 
            soundData.length / 2));
        double[] secondHalf = doubleSpeed(splitSound(soundData, 
            soundData.length / 2, soundData.length));
        
        double[] newSoundData = new double[firstHalf.length + secondHalf.length];
        int index = 0;
        for (int i = 0; i < firstHalf.length; i++)
        {
            newSoundData[index] = firstHalf[i];
            index++;
        }
        for (int j = 0; j < secondHalf.length; j++)
        {
            newSoundData[index] = secondHalf[j];
            index++;
        }
        return newSoundData;

    }
}