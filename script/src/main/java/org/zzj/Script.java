package org.zzj;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

/**
 * @auther: stan
 * @create: 2021-04-21 16:04
 */
public class Script {

    public static void main(String[] args) throws Exception {
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor vmd : list) {
            if (vmd.displayName().endsWith("Main")) {
                VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
                //todo
                virtualMachine.loadAgent("C:/Users/Administrator/IdeaProjects/netty/agent/target/agent.jar ", "cxs");
                System.out.println("ok");
                virtualMachine.detach();
            }
        }
    }
}
