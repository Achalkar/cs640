
public class HessianUtil {

	private HessianUtil(){
		//Empty private contructor. 
	}// HessianUtil
	
	private static final String HESSIAN_URL = "http://%s";
	
	/**
	 * To create a hessian webservice client for the requested URL and the
	 * Interface
	 * 
	 * @param serviceHost
	 * @param serviceInterface
	 * @param url
	 * @param username
	 * @param password
	 * @return
	 * @throws MalformedURLException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getService(String serviceHost,
			Class<T> serviceInterface, String url, String username,
			String password) throws MalformedURLException {
		url = String.format(HESSIAN_URL, serviceHost + url);
		HessianProxyFactory factory = new HessianProxyFactory();
		if (username != null && password != null) {
			factory.setUser(username);
			factory.setPassword(password);
		}// if
		factory.setOverloadEnabled(true);
		return (T) factory.create(serviceInterface, url);
	}// getService

	/**
	 * Overloaded Method to create a hessian webservice client for the requested
	 * URL and the Interface
	 * 
	 * @param serviceHost
	 * @param serviceInterface
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 */
	public static <T> T getService(String serviceHost, Class<T> serviceInterface,
			String url) throws MalformedURLException {
		return getService(serviceHost, serviceInterface, url, null, null);
	}// getService
}// HessianUtil
