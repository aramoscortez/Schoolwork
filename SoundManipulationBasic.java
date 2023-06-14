/**
* Creating several methods to manipulate monaural wave files. In these methods,
* we create, traverse, manipulate, and return arrays. 
*
* @author Abby Ramos Cortez
*
* @version 19.0.1 2023-03-18
*
*/
import java.util.Arrays;

public class SoundManipulationBasic
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
        /* To illustrate how this works, 
        * (soundData[element index] + soundData[element index]) - the second 
        * soundData[element index] represents an increase of 100% in volume.
        * (soundData[element index] + soundData[element index]) is the same as
        * (soundData[element index] * 2) which is why we can use the changeVolume
        * method.
        */
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
        /*
        * (soundData[element index] - (soundData[element index] * 1.0/2.0)) is 
        * the same as (soundData[element index] * 1.0/2.0) which is why we can use 
        * the changeVolume method.
        */
    }

    /** 
    * Creates a new sound by appending a sound to another sound.
    *
    * @param soundData1 an array that represents the first sound data
    * @param soundData2 an array that represents the second sound data
    * @return an array with the first sound data and the second sound data combined
    * together. The second sound data is added at the end of the first sound data.
    */
    public static double[] appendSounds(double[] soundData1, double[] soundData2)
    {
        int totalSize = soundData1.length + soundData2.length;
        double[] newSoundData = new double[totalSize];
        int index = 0; // index represents the index of the newSoundData array
        for (int i = 0; i < soundData1.length; i++)
        {
            newSoundData[index] = soundData1[i]; 
            index++;
        }
        for (int j = 0; j < soundData2.length; j++)
        {
            newSoundData[index] = soundData2[j];
            index++;
        }        
        return newSoundData;
    }

    /** 
    * Merges two sounds together, forming a new sound. Both sounds must be the same
    * length for the sounds to be merged together. Elements of the same index are
    * added together. The outcome is the merged sound.
    *
    * @param soundData1 an array that represents the first sound data
    * @param soundData2 an array that represents the second sound data
    * @return an array that represents the merged sound data
    */
    public static double[] mergeSounds(double[] soundData1, double[] soundData2)
    {
        int arbitrarySize = 0;
        double[] newSoundData = new double[arbitrarySize];

        if (soundData1.length == soundData2.length)
        {
            newSoundData = new double[soundData1.length];
            for (int i = 0; i < soundData1.length; i++)
            {
                newSoundData[i] = soundData1[i] + soundData2[i];
            }
        }
        return newSoundData;
    }
}