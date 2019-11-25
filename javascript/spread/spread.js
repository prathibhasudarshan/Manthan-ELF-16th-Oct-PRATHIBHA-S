let items=[
    {
        id:01,
        name:"pree",
        price:876
    },
    {
        id:02,
        name:"rre",
        price:8766
    }

]
items[0].id=5;
console.log("after modification",items)

var item={...items[0]}
console.log("item 0",item)
item.id=20;
console.log("items",items)
console.log("items 0",item)
console.log("items",items)

let person={
    name:"shalini",
    age:20,
    hobbies:["sing","music"]
}

let address={
    city:"blore",
    pin:10
}
console.log("=======")
let add={...person,...address}
console.log(add)


function sum(...args){
    let value=0;

    for(let i=0;i<args.length;i++){
        value+=args[i]
        console.log(value)
    }
}
sum(1,2,6)

