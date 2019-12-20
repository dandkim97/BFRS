import { Plane } from './plane';

export class Trip {
id: number;
seatsTaken: number;
tripFrom: string;
tripTo: string;
departure: string;
arrival: string;
price: number;
plane: Plane;
status: string;
}
