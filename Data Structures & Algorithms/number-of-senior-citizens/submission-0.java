class Solution {
    public int countSeniors(String[] details) {
        int seniors = 0;

        for (var detail : details) {
            if (isSenior(detail)) {
                seniors++;
            }
        }
        return seniors;
    }

    private boolean isSenior(String detail) {
        return getAge(detail.substring(11, 13)) > 60;
    }

    private int getAge(String age) {
        if (age.charAt(0) == '0')
            return age.charAt(1) - '0';
        
        return Integer.parseInt(age);
    }
}