/**
 * 
 */
package net.sf.fmj.test.tracing;

import javax.media.Buffer;
import javax.media.Format;

/**
 * 
 * @author Ken Larson
 *
 */
public class TracingBuffer extends Buffer
{
	private final StringBuffer b = new StringBuffer();
	
	public StringBuffer getStringBuffer() {return b;}

	//@Override
	public Object clone()
	{
		b.append("clone\n");
		return super.clone();
	}

	//@Override
	public void copy(Buffer arg0, boolean arg1)
	{
		b.append("clone\n");
		super.copy(arg0, arg1);
	}

	//@Override
	public void copy(Buffer arg0)
	{
		b.append("copy\n");
		super.copy(arg0);
	}

	//@Override
	public Object getData()
	{
		b.append("getData\n");
		return super.getData();
	}

	//@Override
	public long getDuration()
	{
		b.append("getDuration\n");
		return super.getDuration();
	}

	//@Override
	public int getFlags()
	{
		b.append("getFlags\n");
		return super.getFlags();
	}

	//@Override
	public Format getFormat()
	{
		b.append("getFormat\n");
		return super.getFormat();
	}

	//@Override
	public Object getHeader()
	{
		b.append("getHeader\n");
		return super.getHeader();
	}

	//@Override
	public int getLength()
	{
		b.append("getLength\n");
		return super.getLength();
	}

	//@Override
	public int getOffset()
	{
		b.append("getOffset\n");
		return super.getOffset();
	}

	//@Override
	public long getSequenceNumber()
	{
		b.append("getSequenceNumber\n");
		return super.getSequenceNumber();
	}

	//@Override
	public long getTimeStamp()
	{
		b.append("getTimeStamp\n");
		return super.getTimeStamp();
	}

	//@Override
	public boolean isDiscard()
	{
		b.append("isDiscard\n");
		return super.isDiscard();
	}

	//@Override
	public boolean isEOM()
	{
		b.append("isEOM\n");
		return super.isEOM();
	}

	//@Override
	public void setData(Object arg0)
	{
		b.append("setData\n");
		super.setData(arg0);
	}

	//@Override
	public void setDiscard(boolean arg0)
	{
		b.append("setDiscard\n");
		super.setDiscard(arg0);
	}

	//@Override
	public void setDuration(long arg0)
	{
		b.append("setDuration\n");
		super.setDuration(arg0);
	}

	//@Override
	public void setEOM(boolean arg0)
	{
		b.append("setEOM\n");
		super.setEOM(arg0);
	}

	//@Override
	public void setFlags(int arg0)
	{
		b.append("setFlags\n");
		super.setFlags(arg0);
	}

	//@Override
	public void setFormat(Format arg0)
	{
		b.append("setFormat(%1)\n".replaceAll("%1", "" + arg0));
		super.setFormat(arg0);
	}

	//@Override
	public void setHeader(Object arg0)
	{
		b.append("setHeader\n");
		super.setHeader(arg0);
	}

	//@Override
	public void setLength(int arg0)
	{
		b.append("setLength(%1)\n".replaceAll("%1", "" + arg0));
		super.setLength(arg0);
	}

	//@Override
	public void setOffset(int arg0)
	{
		b.append("setOffset(%1)\n".replaceAll("%1", "" + arg0));
		super.setOffset(arg0);
	}

	//@Override
	public void setSequenceNumber(long arg0)
	{
		b.append("setSequenceNumber\n");
		super.setSequenceNumber(arg0);
	}

	//@Override
	public void setTimeStamp(long arg0)
	{
		b.append("setTimeStamp\n");
		super.setTimeStamp(arg0);
	};
	
}