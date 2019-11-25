class Person{
    constructor(name,age)
    {
        this.name=name;
        this.name=age;
    }
    getname(){
        return this.name;
    }
    getage(){
        return this.age;
    }
}
const p1=new Person("iiii",45)
const p2=new Person("jjjj",76)
console.log(p1.name)
let pname=(p2.getname())
console.log(pname)
console.log(p1.age)
// console.log(p2.name)
// console.log(p2.age)


class Teacher extends Person{
    constructor(name,age,sub)
    {
        super(name,age)
        this.sub=sub;
    }

    getsub(){
        return this.sub;
    }
}
const teacher=new Teacher("guru",23,"maths")
console.log(teacher.getsub())

