package xexloaderwv;

import ghidra.app.util.bin.BinaryReader;
import ghidra.app.util.bin.ByteArrayProvider;

public class XEXDeltaPatch
{
	public int old_addr;
	public int new_addr;
	public short uncompressed_len;
	public short compressed_len;
	public byte[] patch_data;
	public XEXDeltaPatch(byte[] data, int pos) throws Exception
	{
		BinaryReader b = new BinaryReader(new ByteArrayProvider(data), false);	
		old_addr = b.readInt(pos);
		new_addr = b.readInt(pos + 4);
		uncompressed_len = b.readShort(pos + 8);
		compressed_len = b.readShort(pos + 10);
		patch_data = Helper.ReadArray(b, pos + 12, compressed_len);
	}
}
