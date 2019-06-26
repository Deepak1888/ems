package com.globant.EMS.loadbalancer;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

public class PickFirstLoadBalancerRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {

        List<Server> upList = getLoadBalancer().getReachableServers();
        //returns the first lb in the list every time
        if (upList != null && upList.size() > 0) {
        	System.out.println("-----------------------------------------------"+upList.get(0));
            return upList.get(0);
        }
        return null;
    }
}