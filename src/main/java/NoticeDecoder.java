
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;
import other.Notice;

import java.util.List;

/**
 * @auther: stan
 * @create: 2021-04-30 15:17
 */
public class NoticeDecoder extends MessageToMessageDecoder<DatagramPacket> {
    /**
     * 解码器核心实现
     * @param channelHandlerContext 处理器上下文
     * @param datagramPacket 数据报
     * @param list 消息列表
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> list) throws Exception {
        //数据报内容
        ByteBuf data = datagramPacket.content();
        //通知id
        int id = data.readInt();
        //发送时间
        long time = data.readLong();
        //分隔符
        data.readByte();
        //当前索引
        int idx = data.readerIndex();
        //通知内容
        String content = data.slice(idx, data.readableBytes()).toString(CharsetUtil.UTF_8);
        //加入消息列表
        list.add(new Notice(id,content, datagramPacket.sender()));
    }
}
