package com.example.application.api;

import com.example.application.domain.Lease;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import java.util.Set;

public class LeaseApi {
    private RestTemplate restTemplate = new RestTemplate();

    private void save() {
//        Lease lease = new Lease();
//        return null;
    }

    public Lease read(String id) {
        return null;
    }

    public Lease update(String id) {
        return null;
    }

    public Lease delete(String id) {
        String deleteRequest = "/delete/"; //+ Lease.getLeaseId();
        restTemplate.delete(deleteRequest);
        return null;
    }

    public Set<Lease> findALl() {
//        String apiUrl = url + "getAll";
//        ResponseEntity<Lease[]> response1 = restTemplate.getForEntity(apiUrl, Lease[].class);
//
//        if (response1.getStatusCode().is2xxSuccessful()) {
//            Lease[] lease = response1.getBody();
//            return new HashSet<>(lease);//Arrays.asList(lease));
//        } else {
//            return Collections.emptySet();
//        }
        return null;
    }
}
