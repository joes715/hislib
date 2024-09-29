
package com.hospital.adapt.mapper.common;

import java.util.List;

public interface BnCommonMapper<T> extends CommonMapper<T> {
    List<T> queryByWardId(String ward_id);
}
