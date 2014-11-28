package FacadeLayer;

import LogicLayer.HashTable;

public class HashTableWrapper
{

    private double[][] rates;
    private int rowCount = 2;
    private int colCount = 3;

    public HashTableWrapper(HashTable hashTable)
    {
        if (hashTable != null)
        {
            rates = new double[rowCount][colCount];
            rates[0][0] = hashTable.getSAVINGS_RATE_1000_TO_2000();
            rates[0][1] = hashTable.getSAVINGS_RATE_2000_TO_3000();
            rates[0][2] = hashTable.getSAVINGS_RATE_OVER_3000();
            rates[1][0] = hashTable.getCHECKING_RATE_1000_TO_2000();
            rates[1][1] = hashTable.getCHECKING_RATE_2000_TO_3000();
            rates[1][2] = hashTable.getCHECKING_RATE_OVER_3000();
        }
    }

    public double getTableValue(int rowIndex, int columnIndex)
    {
        return rates[rowIndex][columnIndex];
    }

    public int getRowCount()
    {
        return rowCount;
    }

    public int getColCount()
    {
        return colCount;
    }
}
