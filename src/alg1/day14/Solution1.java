package alg1.day14;

/**
 * 190. 颠倒二进制位
 */
public class Solution1 {
    /**
     * 位运算 >> 和 >>>的区别
     * >> 和符号位有关，高位负数补1非负数补0
     * >>> 和符号位无光，高位只补0
     */
    public static void main(String[] args) {
        System.out.println(Integer.parseUnsignedInt("00000010100101000001111010011100", 2));
        System.out.println(Integer.parseUnsignedInt("11111111111111111111111111111101", 2));
        System.out.println(reverseBits(43261596));
        System.out.println(reverseBits(-3));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(-4 >> 2));
        System.out.println(Integer.toBinaryString(-4 >>> 2));
        System.out.println(Integer.toBinaryString(Integer.parseUnsignedInt("10111111111111111111111111111110", 2) >> 1));
        System.out.println(Integer.toBinaryString(Integer.parseUnsignedInt("10111111111111111111111111111110", 2) >>> 1));
        System.out.println(Integer.toBinaryString(43261596 >>> 1 & M1 | (43261596 & M1) << 1));
    }

    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    /**
     * 不太理解这种算法
     * n = n >>> 1 & M1 | (n & M1) << 1;
     */
    public static int reverseBits(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }

    /**
     * 依次获取最低位并输出到结果中
     */
    public static int reverseBits1(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);  // (n & 1)保留最低位，<< (31 - i)移动至第i+1位
            n >>>= 1;//最低位舍弃
        }
        return rev;
    }
}
