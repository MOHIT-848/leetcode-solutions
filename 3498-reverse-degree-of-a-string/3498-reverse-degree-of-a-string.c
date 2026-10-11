int reverseDegree(char* s) {
    int result = 0;
    int i = 0;

    while (s[i] != '\0') {
        int value = 'z' - s[i] + 1;
        int pro = value * (i + 1);

        result += pro;
        i++;
    }

    return result;
}