package com.example.ipaddressfilter;

import com.github.jgonian.ipmath.Ipv4;
import com.github.jgonian.ipmath.Ipv4Range;
import org.apache.commons.net.util.SubnetUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

/**
 * @author S-Serajzadeh
 * @Date 8/20/22
 * @Project PANEL IOT-Bank
 */

@Controller
public class controllers {
    @GetMapping()
    public Optional<?> checkIpAddress(@PathParam("ip") String icdrIp, String clientIp) {
        SubnetUtils subnetUtils = new SubnetUtils(icdrIp);
        Ipv4 startIPAddress = Ipv4.of(subnetUtils.getInfo().getLowAddress());
        Ipv4 endIPAddress = Ipv4.of(subnetUtils.getInfo().getHighAddress());
        Ipv4Range ipRange = Ipv4Range.from(startIPAddress).to(endIPAddress);
        Ipv4 inputIPAddress = Ipv4.of(clientIp);
        return Optional.ofNullable(null);
//        return ipRange.contains(inputIPAddress);
    }
//    @GetMapping()
//    public Boolean checkToString(@PathParam("ip") String icdrIp) throws FileNotFoundException {
//        File file = new File("Dotxt.txt");
//        Scanner scanner = new Scanner(file);
//        while (scanner.hasNext()){
//            String data = sc
//        }
//        return ipRange.contains(inputIPAddress);
//    }
}
