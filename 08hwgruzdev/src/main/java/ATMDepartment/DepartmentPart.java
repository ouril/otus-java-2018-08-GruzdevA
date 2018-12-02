package ATMDepartment;

public interface DepartmentPart {
    int acceptGetValue(DepartmentVisitor visitor);

    void acceptSetBasicState(DepartmentVisitor visitor);
}
