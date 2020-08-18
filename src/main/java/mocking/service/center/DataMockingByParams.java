package mocking.service.center;

import java.util.Map;

public class DataMockingByParams extends DataMocking<String> {

    @Override
    public boolean isMatch(Map<String, String> requestArgs) {
        for (Map.Entry<String, String> requestArgsEntry : requestArgs.entrySet()) {
            String requestArgsKey = requestArgsEntry.getKey();
            String requestArgsValue = requestArgsEntry.getValue();
            if (this.args.containsKey(requestArgsKey)) {
                String argsValue = this.args.get(requestArgsKey);
                if ((argsValue == null && requestArgsValue != null) || (argsValue != null && requestArgsValue == null))
                    return false;
            } else {
                return false;
            }
        }
        return true;
    }
}
