public class LargestRectangleHistogram {
public int largestRectangleArea(int[] height) {
            if ((height == null) || (height.length == 0)) {
                return 0;
            }
            Stack<Integer> stack = new Stack<Integer>();
            int maxArea = 0;
            int tmpArea = 0;
            int stackTop;
            for (int i = 0; i < height.length; i++){
                if (stack.empty() || height[i] >= height[stack.peek()]) {
                    stack.push(i);
                } else {
                        while(!stack.empty()&& height[i] < height[stack.peek()]){
                            stackTop = stack.pop();
                            if (stack.empty()){
                                tmpArea = i* height[stackTop];
                            } else {
                                tmpArea = (i - 1 - stack.peek()) *height[stackTop];
                            }
                            
                            if (tmpArea > maxArea) {
                                maxArea = tmpArea;
                            }
                        }
                        stack.push(i);
                    
                }
            }
            while(!stack.empty()){
                stackTop = stack.pop();
                if (stack.empty()) {
                    tmpArea = height.length * height[stackTop];
                } else {
                    tmpArea = (height.length -1- stack.peek())*height[stackTop];
                }
                if (tmpArea > maxArea) {
                    maxArea = tmpArea;
                }
                        
            }
            return maxArea;
        }
}
