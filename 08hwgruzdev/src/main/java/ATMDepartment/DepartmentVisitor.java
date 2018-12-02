package ATMDepartment;

import ATM.CommonATM;

public interface DepartmentVisitor {
    public void visitSetBasicState(CommonATM terminal);

    public int visitGetValueAtm(CommonATM terminal);
}
