package com.example.logisticks.dao;

import com.example.logisticks.models.Agent;
import com.example.logisticks.models.AgentAssignedOrder;
import com.example.logisticks.requests.AgentRequest;
import com.example.logisticks.responses.AgentResponse;

import java.util.List;

public interface AgentDAO {
    int signIn(String phoneNumber, String password);
    int signUp(String phoneNumber, String password, String name, String houseNumber, String locality, int locationId, String vehicleNumber, int salary);

    List<AgentAssignedOrder> viewAssignedOrders();
    AgentResponse markAsDelivered(AgentRequest agentRequest);
}
