package by.vasilevich.navigation;

import by.vasilevich.navigation.commands.*;

public enum Commands {
	REGISTRATION_USER {

		@Override
		public ICommand getCommand() {
			// TODO Auto-generated method stub
			return new CommandRegistration();
		}
	},
	LOGIN_USER {

		@Override
		public ICommand getCommand() {
			// TODO Auto-generated method stub
			return new CommandLogin();
		}
	},
	LOGOUT_USER {
		@Override
		public ICommand getCommand() {
			return new CommandLogout();
		}
	},
	ITEM_NEWS {
		@Override
		public ICommand getCommand() {
			return new CommandItemNews();
		}
	}
	;

	public abstract ICommand getCommand();
}
