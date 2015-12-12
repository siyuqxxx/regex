package com.regex;

class FindMark
{
    private int paStart;
    private int paEnd;
    
    public FindMark()
    {
        
    }
    
    public FindMark(int start, int end)
    {
        paStart = start;
        paEnd = end;
    }

    public int getPaStart()
    {
        return paStart;
    }

    public int getPaEnd()
    {
        return paEnd;
    }       
    
    public int length()
    {
        return paEnd - paEnd;
    }
    
    public String toString()
    {
        return "Start: " + paStart + "; End:" + paEnd;
    }
}
