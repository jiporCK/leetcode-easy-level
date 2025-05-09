public class TreeExample {
    public static void main(String[] args) {
        TreeNode ceo = new TreeNode("CEO");

        TreeNode managerOne = new TreeNode("ManagerOne");
        TreeNode managerTwo = new TreeNode("ManagerTwo");

        TreeNode empOne = new TreeNode("empOne");
        TreeNode empTwo = new TreeNode("empTwo");
        TreeNode empThree = new TreeNode("empThree");

        ceo.addChildren(managerOne);
        ceo.addChildren(managerTwo);

        managerOne.addChildren(empOne);
        managerOne.addChildren(empTwo);

        managerTwo.addChildren(empThree);
    }
}
