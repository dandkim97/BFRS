import { Login } from './login';
import { Plane } from './plane';

export class Review {
    id: number;
    customer: Login;
    plane: Plane;
    rating: number;
}
