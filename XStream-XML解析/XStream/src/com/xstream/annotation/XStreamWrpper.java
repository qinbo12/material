package com.xstream.annotation;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;

/**
 * 重写XStream类
 * @author qinbo
 *
 */
public class XStreamWrpper extends XStream {
	
	@Override
	protected MapperWrapper wrapMapper(MapperWrapper next) {
		return new MapperWrapper(next) {
            /*
             * (non-Javadoc)
             *
             * @see
             * com.thoughtworks.xstream.mapper.MapperWrapper#shouldSerializeMember
             */
            @Override
            public boolean shouldSerializeMember(@SuppressWarnings("rawtypes") Class definedIn, String fieldName) {
                // 不能识别的节点，掠过。
                if (definedIn == Object.class) {
                    return false;
                }
                return super.shouldSerializeMember(definedIn, fieldName);
            }
        };

	}
}
