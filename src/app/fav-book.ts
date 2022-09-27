import { ItemFav } from "./item-fav";
import { Users } from "./users";

export class FavBook 
{
    id:number;
	itemFav:ItemFav[]=[];
	users=new Users();
}
