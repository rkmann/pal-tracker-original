package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String PORT;
    private String MEMORY_LIMIT;
    private String CF_INSTANCE_INDEX;
    private String CF_INSTANCE_ADDR;

    public EnvController() {

    }

    public EnvController(@Value("${PORT}") String PORT,@Value("${MEMORY_LIMIT}") String MEMORY_LIMIT, @Value("${CF_INSTANCE_INDEX}") String CF_INSTANCE_INDEX, @Value("${CF_INSTANCE_ADDR}") String CF_INSTANCE_ADDR) {
        this.PORT = PORT;
        this.MEMORY_LIMIT = MEMORY_LIMIT;
        this.CF_INSTANCE_INDEX = CF_INSTANCE_INDEX;
        this.CF_INSTANCE_ADDR = CF_INSTANCE_ADDR;
    }

    public Map<String, String> getEnv(){
        Map<String, String> envMap = new HashMap<String, String>();
        envMap.put("PORT", this.getPORT());
        envMap.put("MEMORY_LIMIT", this.getMEMORY_LIMIT());
        envMap.put("CF_INSTANCE_INDEX", this.getCF_INSTANCE_INDEX());
        envMap.put("CF_INSTANCE_ADDR", this.getCF_INSTANCE_ADDR());
        return envMap;

    }

    public String getPORT() {
        return PORT;
    }

    public void setPORT(String PORT) {
        this.PORT = PORT;
    }

    public String getMEMORY_LIMIT() {
        return MEMORY_LIMIT;
    }

    public void setMEMORY_LIMIT(String MEMORY_LIMIT) {
        this.MEMORY_LIMIT = MEMORY_LIMIT;
    }

    public String getCF_INSTANCE_INDEX() {
        return CF_INSTANCE_INDEX;
    }

    public void setCF_INSTANCE_INDEX(String CF_INSTANCE_INDEX) {
        this.CF_INSTANCE_INDEX = CF_INSTANCE_INDEX;
    }

    public String getCF_INSTANCE_ADDR() {
        return CF_INSTANCE_ADDR;
    }

    public void setCF_INSTANCE_ADDR(String CF_INSTANCE_ADDR) {
        this.CF_INSTANCE_ADDR = CF_INSTANCE_ADDR;
    }
}
