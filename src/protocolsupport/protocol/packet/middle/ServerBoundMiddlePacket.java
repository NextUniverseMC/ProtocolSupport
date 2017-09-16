package protocolsupport.protocol.packet.middle;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middleimpl.ServerBoundPacketData;
import protocolsupport.utils.Utils;
import protocolsupport.utils.recyclable.RecyclableCollection;

public abstract class ServerBoundMiddlePacket extends MiddlePacket {

	public abstract void readFromClientData(ByteBuf clientdata);

	public abstract RecyclableCollection<ServerBoundPacketData> toNative();

	@Override
	public String toString() {
		return Utils.toStringAllFields(this);
	}

}
