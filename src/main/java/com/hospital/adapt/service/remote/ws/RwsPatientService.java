
package com.hospital.adapt.service.remote.ws;


import com.hospital.adapt.model.wrapper.PatsWrapper;

public interface RwsPatientService {
    public void synDelete(String stayNos);

    public void synData(PatsWrapper sp);
}
