import { Login } from './login';
import { Trip } from './trip';
import { CommentStmt } from '@angular/compiler';

export class Logintrip {
    userId: number;
    userName: string;
    model: string;
    tripFrom: string;
    tripTo: string;
    departure: string;
    arrival: string;
    numSeats: number;
    isRound: number;
    tripCost: number;
    tripId: number;
    id: number;
    login: Login;
    trip: Trip;
    cost: number;
}
