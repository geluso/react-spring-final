import "./Root.css";
import { Outlet, Link } from "react-router-dom";

import { routes, router } from "./routes";
import Suffix from "../components/time/Suffix";

const Root = () => {
    return <div id="root">
        <div>
            <nav>
                <ul>
                    <li>Links:</li>
                    {routes.map((route) => {
                        return <li key={route.name}>
                            <Link to={route.path}>{route.name}</Link>
                        </li>
                    })}
                </ul>
            </nav>
        </div>
        <div>

            <Outlet />

            <div>
                <hr></hr>
                (c) Copyright the <Suffix value={24} /> year of 2000
                <hr></hr>
            </div>
        </div>
    </div>;
}

export default Root;