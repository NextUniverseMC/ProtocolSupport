package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_6;

import com.google.gson.JsonObject;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.api.chat.ChatAPI.MessagePosition;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleChat;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.utils.Utils;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableEmptyList;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class Chat extends MiddleChat {

	@Override
	public RecyclableCollection<ClientBoundPacketData> toData() {
		if (position == MessagePosition.HOTBAR) {
			return RecyclableEmptyList.get();
		}
		ProtocolVersion version = connection.getVersion();
		ClientBoundPacketData serializer = ClientBoundPacketData.create(ClientBoundPacket.PLAY_CHAT_ID, version);
		StringSerializer.writeString(serializer, version, encode(message.toLegacyText(cache.getLocale())));
		return RecyclableSingletonList.create(serializer);
	}

	private static String encode(String message) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("text", message);
		return Utils.GSON.toJson(jsonObject);
	}

}
